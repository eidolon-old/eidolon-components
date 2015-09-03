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

import org.junit.*
import space.eidolon.component.config.parsing.PropertyToken
import space.eidolon.component.config.parsing.exception.MatchNotFoundException
import kotlin.properties.Delegates
import kotlin.test.*

/**
 * PropertyMatcherSpec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
public final class PropertyMatcherSpec {
    private var matcher: PropertyMatcher by Delegates.notNull()

    Before fun beforeEach() {
        matcher = PropertyMatcher()
    }

    Test fun testMatchWithValidInput() {
        val input = "foo: 'bar'"
        val result = matcher.match(input)

        assertTrue(result is MatcherResult)
    }
}
