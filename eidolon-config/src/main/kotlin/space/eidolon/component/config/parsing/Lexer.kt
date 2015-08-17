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

import org.apache.commons.lang3.StringEscapeUtils
import space.eidolon.component.config.parsing.exception.MatchNotFoundException
import space.eidolon.component.config.parsing.exception.ParseException
import space.eidolon.component.config.parsing.matcher.Matcher
import space.eidolon.component.config.parsing.matcher.MatcherResult
import java.util.*
import kotlin.text.MatchGroupCollection

/**
 * Lexer
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
public class Lexer(private var input: String) {
    private val matchers = ArrayList<Matcher>()

    /**
     * Add a matcher to the internal matcher array
     */
    public fun addMatcher(matcher: Matcher) {
        matchers.add(matcher)
    }

    /**
     * Check if this Lexer has any remaining input to process
     *
     * @return True if there is input remaining
     */
    public fun hasInput(): Boolean {
        return input.trim().isNotEmpty()
    }

    /**
     * Attempt to read the next token in the current input stream
     *
     * @return The next token.
     * @throws ParseException if no matches are found.
     */
    public fun readNextToken(): Token {
        var result: MatcherResult? = null

        for (matcher in matchers) {
            try {
                result = matcher.match(input)
                break
            } catch (e: MatchNotFoundException) {
                // Maybe log this?
            }
        }

        if (result == null) {
            throw ParseException("No match found.")
        }

        input = input.replaceFirstLiteral(result.rawMatch, "")

        return result.token
    }
}
