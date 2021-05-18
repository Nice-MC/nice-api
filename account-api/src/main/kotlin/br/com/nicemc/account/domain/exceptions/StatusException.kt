package br.com.nicemc.account.domain.exceptions

class RankNotFoundException(message: String) : DomainException(message)

class IllegalCurrencyActionException(message: String): DomainException(message)