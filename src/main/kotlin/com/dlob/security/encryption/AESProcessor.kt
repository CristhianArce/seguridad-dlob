package com.dlob.security.encryption

import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class AESProcessor {

    private val numbers = listOf(-103, 24, 6, 16, -112, 73, 87, 20, 116, 56, 86, -49, 20, -82, -23, 102, 126, -26, -24, 38, -26, -12, -64, -29, 8, 115, -99, 19, 76, -48, -119, -91)

    private val SECRET_KEY = numbers.map { it.toByte() }.toByteArray()

    fun aesDecrypt(encryptedData: ByteArray): String {
        val secretKey = SecretKeySpec(SECRET_KEY, "AES");
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val ivParameterSpec = IvParameterSpec(ByteArray(16)) // Use the same IV as used in encryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec)
        val decryptedDate = cipher.doFinal(Base64.getDecoder().decode(encryptedData))
        return String(decryptedDate)
    }
}