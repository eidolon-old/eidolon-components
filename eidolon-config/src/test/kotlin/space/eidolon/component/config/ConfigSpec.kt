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

package space.eidolon.component.config

import org.junit.runner.RunWith
import org.junit.runners.Suite
import space.eidolon.component.config.parsing.matcher.PropertyMatcherSpec

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PropertyMatcherSpec::class
)
public final class ConfigSpec {
    // Run all component tests.
}
