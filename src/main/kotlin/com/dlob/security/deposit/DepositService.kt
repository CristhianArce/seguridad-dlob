package com.dlob.security.deposit

import com.dlob.security.encryption.AESProcessor
import com.dlob.security.entities.Transaction
import com.dlob.security.models.DepositRequest
import com.dlob.security.models.TransactionData
import com.dlob.security.repository.AccountRepository
import com.dlob.security.repository.ParamRepository
import com.dlob.security.repository.TransactionRepository
import com.google.gson.Gson
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import kotlin.random.Random

@Service
class DepositService(
    private val aesProcessor: AESProcessor,
    private val transactionRepo: TransactionRepository,
    private val accountRepo: AccountRepository,
    private val paramRepo: ParamRepository) {

    private val gson = Gson()

    fun deposit(depositRequest: DepositRequest): Transaction {
        val param = paramRepo.findById(1)
        if (param.get().param) {
            Thread.sleep(Random.nextLong(0, 3000))
            throw IllegalArgumentException("No connection Available")
        }
        val payload = depositRequest.payload
        val transactionData = aesProcessor.aesDecrypt(payload.encodeToByteArray())
        val deposit = gson.fromJson(transactionData, TransactionData::class.java)
        if(accountRepo.findAccountByReference(deposit.customer.account) != null) {
            val transaction = Transaction(
                reference = deposit.transaction.reference,
                type = deposit.transaction.type,
                amount = deposit.transaction.amount.value,
                currency = deposit.transaction.amount.currency,
                description = deposit.transaction.description,
                account = deposit.customer.account)
            val depo = transactionRepo.save(transaction)
            return depo
        }
        throw IllegalArgumentException("No account ${deposit.transaction.reference} could be found!")
    }
}