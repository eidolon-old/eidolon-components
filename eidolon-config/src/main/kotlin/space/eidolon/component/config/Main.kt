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

/**
 * Config Component Main
 *
 * @param args Application arguments
 */
fun main(args: Array<String>) {
    val lexer = Lexer("""key: "va\"\" testing lue"""")
    val token1 = lexer.readNextToken()
    val token2 = lexer.readNextToken()

    println(token1)
    println(token2)

//    println(PropertyToken("foo"))
//
//    println(ArrayStartToken())
//    println(ArrayEndToken())
//
//    println(ObjectStartToken())
//    println(ObjectEndToken())
//
//    println(NullToken())
//    println(FalseToken())
//    println(TrueToken())
//
//    println(NumberToken("123"))
//    println(StringToken("foo"))
}
