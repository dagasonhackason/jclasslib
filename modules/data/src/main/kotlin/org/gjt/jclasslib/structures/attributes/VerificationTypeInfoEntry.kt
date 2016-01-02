/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.structures.Structure
import org.gjt.jclasslib.structures.ClassFile
import java.io.DataInput
import java.io.DataOutput

/**
 * Describes an entry in a StackMapFrameEntry attribute structure.
 */
abstract class VerificationTypeInfoEntry(
        /**
         * The verification type
         */
        val type: VerificationType
) : Structure() {


    override fun writeData(output: DataOutput) {
        output.writeByte(type.tag)
    }

    override fun readData(input: DataInput) {

    }

    override val debugInfo: String
        get() = "of type $type"

    /**
     * Returns the bytecode length of the entry.
     */
    open val length: Int
        get() = 1

    /**
     * Append the verbose representation to a string builder.
     */
    open fun appendTo(buffer: StringBuilder) {
        buffer.append(type)
    }

}