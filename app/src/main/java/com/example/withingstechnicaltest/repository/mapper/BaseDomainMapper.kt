package com.example.withingstechnicaltest.repository.mapper

abstract class BaseDomainMapper<API, DOMAIN> {
    abstract fun toDomain(api: API): DOMAIN
}