package com.example.roomdatabase.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase.repositori.AplikasiSiswa
import com.example.roomdatabase.viewmodel.EntryViewModel
import com.example.roomdatabase.viewmodel.HomeViewModel
import com.example.roomdatabase.viewmodel.DetailViewModel
import com.example.roomdatabase.viewmodel.EditViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory {

        // HomeViewModel
        initializer {
            HomeViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        // EntryViewModel
        initializer {
            EntryViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        // DetailViewModel
        initializer {
            DetailViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        // EditViewModel
        initializer {
            EditViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

/**
 * Fungsi ekstensi untuk mengambil instance AplikasiSiswa dari CreationExtras.
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa {
    return (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
}
