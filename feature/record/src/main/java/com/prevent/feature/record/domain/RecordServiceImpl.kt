package com.prevent.feature.record.domain

import android.content.Context
import android.media.AudioFormat
import android.media.MediaRecorder
import omrecorder.AudioRecordConfig
import omrecorder.OmRecorder
import omrecorder.PullTransport
import omrecorder.PullTransport.OnAudioChunkPulledListener
import omrecorder.PullableSource
import omrecorder.Recorder
import java.io.File


class RecordServiceImpl(
    context: Context
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

    override var recordStatus: RecordStatus = RecordStatus.notRecording()
        private set

    override fun startRecord() {

        omRecorder = OmRecorder.wav(
            PullTransport.Default(mic(),
                OnAudioChunkPulledListener { audioChunk -> }),
            File(outputFilePath)
        )

        omRecorder.startRecording()
        recordStatus = RecordStatus.recording()

    }

    override fun stopRecord() {
        try {
            omRecorder.stopRecording()
        } finally {
            recordStatus = RecordStatus.notRecording()
        }
    }
}