package com.prevent.feature.record.domain

import android.media.MediaRecorder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class RecordServiceImpl(
    private val coroutineScope: CoroutineScope = GlobalScope
) : RecordService {

    val mediaRecorder: MediaRecorder = MediaRecorder()


    private val _recorderStatus: Channel<RecordStatus> = Channel()

    @FlowPreview
    override val recordStatus: Flow<RecordStatus>
        get() = _recorderStatus.consumeAsFlow()

    override fun startRecord() {
        mediaRecorder.setOutputFile("/")
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT)
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)
        mediaRecorder.prepare()

        mediaRecorder.start()
        coroutineScope.launch {
            _recorderStatus.send(RecordStatus.recording())
        }
    }

    override fun stopRecord() {
        mediaRecorder.stop()

        coroutineScope.launch {
            _recorderStatus.send(RecordStatus.notRecording())
        }
    }
}