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

import kotlin.text.MatchGroupCollection
import kotlin.text.MatchResult
import kotlin.text.Regex

/**
 * Lexer
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class Lexer(private var input: String) {
    private val propertyRegex = Regex("""^\s*(\"?)([\w-]+)\1\s*\:\s*""")
    private val stringRegex = Regex("""^\s*((?<![\\])['"])((?:.(?!(?<![\\])\1))*.?)\1\s*""")

    fun readNextToken(): Token {
        // todo: unescape values before assigning to tokens

        var matches: MatchGroupCollection
        var match: String
        var token: Token

        if (propertyRegex.hasMatch(input)) {
            // ex: (foo:) or ("bar":)
            matches = propertyRegex.match(input)!!.groups
            token = PropertyToken(matches.get(2)!!.value)

        } else if (stringRegex.hasMatch(input)) {
            // ex: ("foo") or ('bar') or ("baz \"") or ('qux \'')
            matches = stringRegex.match(input)!!.groups
            token = StringToken(matches.get(2)!!.value)

        } else {
            // todo: ParseException
            throw RuntimeException("Unidentifiable token encountered.")
        }

        match = matches.get(0)!!.value
        input = input.replace(match, "")

        return token
    }
}
