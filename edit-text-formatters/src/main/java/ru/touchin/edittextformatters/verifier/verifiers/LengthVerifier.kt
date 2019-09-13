package ru.touchin.edittextformatters.verifier.verifiers

import ru.touchin.edittextformatters.commands.Command
import java.math.BigDecimal

/**
 * Verifier of text input length.
 *
 */
class LengthVerifier(val maxLength: Int) : Verifier<BigDecimal> {

    override fun verify(text: String): Command<BigDecimal> = if (text.length <= maxLength) {
        Command.Success()
    } else {
        Command.Remove(1.toBigDecimal())
    }

}