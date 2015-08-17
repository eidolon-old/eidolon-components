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

package space.eidolon.component.config.parsing.matcher

import org.apache.commons.lang3.StringEscapeUtils
import space.eidolon.component.config.parsing.StringToken
import space.eidolon.component.config.parsing.Token
import space.eidolon.component.config.parsing.exception.MatchNotFoundException
import kotlin.text.Regex

/**
 * StringMatcher
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
public class StringMatcher : Matcher {
    private val pattern = Regex("""^\s*((?<![\\])['"])((?:.(?!(?<![\\])\1))*.?)\1\s*""")

    /**
     * {@inheritDoc}
     */
    public override fun match(input: String): MatcherResult {
        val matches = pattern.match(input)

        if (matches != null) {
            val groups = matches.groups

            return MatcherResult(
                StringToken(StringEscapeUtils.unescapeJava(groups.get(2)!!.value)),
                groups.get(0)!!.value
            )
        }

        throw MatchNotFoundException();
    }
}
