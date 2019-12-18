package com.prevent.feature.record.domain

import android.content.Context
import android.media.AudioFormat
import android.media.MediaRecorder
import com.prevent.data.recorddata.RecordDataRepository
import com.prevent.data.recorddata.model.RecordDataEntity
import com.prevent.data.recorddata.model.valueobject.AudioFilePathValueObject
import com.prevent.data.recorddata.model.valueobject.RecordDateValueObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import omrecorder.AudioRecordConfig
import omrecorder.OmRecorder
import omrecorder.PullTransport
import omrecorder.PullTransport.OnAudioChunkPulledListener
import omrecorder.PullableSource
import omrecorder.Recorder
import java.io.File


class RecordServiceImpl(
    private val coroutineScope: CoroutineScope = GlobalScope,
    private val context: Context,
    private val recordDataRepository: RecordDataRepository
) : RecordService {

    private val outputFilePath = context.externalMediaDirs.first().absolutePath + "/output.wav"
    private var omRecorder: Recorder = OmRecorder.wav(
        PullTransport.Default(mic(),
            OnAudioChunkPulledListener { audioChunk -> }),
        File(outputFilePath)
    )

    private fun mic(): PullableSource {
        return PullableSource.Default(
            AudioRecordConfig.Default(
                MediaRecorder.AudioSource.MIC, AudioFormat.ENCODING_PCM_16BIT,
                AudioFormat.CHANNEL_IN_MONO,
                16000
            )
        )
    }

    override var recordStatus: RecordStatus = RecordStatus.NotRecording()
        private set

    override fun startRecord() {

        omRecorder = OmRecorder.wav(
            PullTransport.Default(mic(),
                OnAudioChunkPulledListener { audioChunk -> }),
            File(outputFilePath)
        )

        omRecorder.startRecording()
        recordStatus = RecordStatus.Recording()

    }

    override fun stopRecord() {
        try {
            omRecorder.stopRecording()
        } finally {
            recordStatus = RecordStatus.NotRecording()
            coroutineScope.launch {
                recordDataRepository.addRecordData(
                    RecordDataEntity(
                        0,
                        AudioFilePathValueObject(outputFilePath),
                        RecordDateValueObject.now()
                    )
                )
            }
        }
    }
}