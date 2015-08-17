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

import space.eidolon.component.config.parsing.exception.MatchNotFoundException
import space.eidolon.component.config.parsing.Token

/**
 * Matcher
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
public interface Matcher {
    /**
     * Matches the given input against a pre-defined set of rules to return a token
     *
     * @param input The input to match against
     * @return The matching token
     * @throws MatchNotFoundException if no match is found
     */
    public fun match(input: String): MatcherResult
}
