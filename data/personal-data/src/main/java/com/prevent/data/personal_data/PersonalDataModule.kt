package com.prevent.data.personal_data

import com.prevent.data.personal_data.domain.PersonalInfoReadonlyRepository
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.domain.PersonalInfoValidator
import com.prevent.data.personal_data.impl.PersonalInfoRepositoryImpl
import com.prevent.data.personal_data.impl.PersonalInfoValidatorImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val personalDataModule = module {
    factory { PersonalInfoRepositoryImpl(androidApplication()) as PersonalInfoRepository }
    factory { PersonalInfoRepositoryImpl(androidApplication()) as PersonalInfoReadonlyRepository }

    factory { PersonalInfoValidatorImpl() as PersonalInfoValidator }
}
