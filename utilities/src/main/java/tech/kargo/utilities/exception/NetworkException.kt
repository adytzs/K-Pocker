package tech.kargo.utilities.exception

import java.lang.Exception

class NetworkException(message: String) : Exception(message) {
    override fun toString(): String {
        return message ?: "MessageException"
    }
}