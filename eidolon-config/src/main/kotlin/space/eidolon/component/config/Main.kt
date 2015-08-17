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

import space.eidolon.component.config.parsing.*
import space.eidolon.component.config.parsing.matcher.PropertyMatcher
import space.eidolon.component.config.parsing.matcher.StringMatcher
import java.util.*

/**
 * Config Component Main
 *
 * @param args Application arguments
 */
fun main(args: Array<String>) {
    val tokens = ArrayList<Token>()
    val lexer = Lexer("""key: "va\"\" testing lue"""")

    lexer.addMatcher(PropertyMatcher())
    lexer.addMatcher(StringMatcher())

    while (lexer.hasInput()) {
        tokens.add(lexer.readNextToken())
    }

    println(tokens)
}
