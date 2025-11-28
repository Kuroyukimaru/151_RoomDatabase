package com.example.roomdatabase.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.repositori.RepositoriSiswa
import com.example.roomdatabase.room.Siswa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    private fun validasiInput(detailSiswa: DetailSiswa): Boolean {
        return with(detailSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun saveSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            CoroutineScope(Dispatchers.IO).launch {
                repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
            }
        }
    }
}

