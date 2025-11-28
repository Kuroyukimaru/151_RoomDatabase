package com.example.roomdatabase.repositori


interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

// 2. Concrete Implementation of the Container
class ContainerDataApp(private val context: Context):
    ContainerApp {

    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}