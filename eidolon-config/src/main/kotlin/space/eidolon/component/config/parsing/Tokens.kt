/**
 * This file is part of the "eidolon-components" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package space.eidolon.component.config.parsing

/**
 * Token
 *
 * Base class for all other tokens.
 *
 * @property lexeme The value associated with the token.
 * @constructor Creates a token with the given lexeme.
 */
interface Token {
    val lexeme: String
}

data class PropertyToken(override val lexeme: String) : Token

data class ArrayStartToken(override val lexeme: String = "[") : Token
data class ArrayEndToken(override val lexeme: String = "]") : Token

data class ObjectStartToken(override val lexeme: String = "{") : Token
data class ObjectEndToken(override val lexeme: String = "}") : Token

data class NullToken(override val lexeme: String = "null") : Token
data class FalseToken(override val lexeme: String = "false") : Token
data class TrueToken(override val lexeme: String = "true") : Token

data class NumberToken(override val lexeme: String) : Token
data class StringToken(override val lexeme: String) : Token
