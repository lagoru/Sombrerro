package com.example.data

import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by lagoru on 26.06.17.
 */
interface DataGetter<in Query, Res : Response> {
    fun performGetQuery(query: Query): Observable<Res>
}

interface DataSaver<in Data, Res : Response> {
    fun performSaveQuery(data: Data): Observable<Res>
}

abstract class RetrofitDataGetter<in Query, Res : Response, ServiceInterface : Any> constructor(retrofit: Retrofit,
                                                                                                serviceInterface: Class<ServiceInterface>) : DataGetter<Query, Res> {
    protected var serviceImpl: ServiceInterface = retrofit.create(serviceInterface)
}