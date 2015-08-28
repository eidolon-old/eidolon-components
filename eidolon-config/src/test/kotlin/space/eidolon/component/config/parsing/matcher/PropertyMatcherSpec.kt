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

import org.jetbrains.spek.api.*
import org.junit.*
import space.eidolon.component.config.parsing.PropertyToken
import space.eidolon.component.config.parsing.exception.MatchNotFoundException
import kotlin.test.*

/**
 * PropertyMatcherSpec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class PropertyMatcherSpec : Spek() { init {
    given("a property matcher") {
        val matcher = PropertyMatcher()

        on("instantiation") {
            it("should be a PropertyMatcher") {
                shouldBeTrue(matcher is PropertyMatcher)
            }

            it("should implement the Matcher interface") {
                shouldBeTrue(matcher is Matcher)
            }
        }

        on("matching input with a property at the start") {
            val input = "property: 'value'"
            val result = matcher.match(input)

            it("should return a MatcherResult") {
                shouldBeTrue(result is MatcherResult)
            }
        }

        on("matching input with no property at the start") {
            val input = "[ 'array' ]"

            it("should throw a MatchNotFoundException") {
                shouldThrow(javaClass<MatchNotFoundException>(), fun() {
                    matcher.match(input)
                })
            }
        }
    }
}}
