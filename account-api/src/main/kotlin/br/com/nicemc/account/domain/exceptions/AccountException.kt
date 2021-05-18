package br.com.nicemc.account.domain.exceptions

class AccountNotFoundException : DomainException("this account hasn't yet been persisted")

class AccountStatusNotFoundException: DomainException("account status hasn't yet been persisted")

class AccountSettingsNotFoundException: DomainException("account settings hasn't yet been persisted")

class AccountGroupNotFoundException: DomainException("account group hasn't yet been persisted")