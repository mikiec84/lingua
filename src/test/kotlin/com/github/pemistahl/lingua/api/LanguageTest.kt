/*
 * Copyright 2018-2019 Peter M. Stahl pemistahl@googlemail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pemistahl.lingua.api

import com.github.pemistahl.lingua.api.Language.AFRIKAANS
import com.github.pemistahl.lingua.api.Language.ALBANIAN
import com.github.pemistahl.lingua.api.Language.ARABIC
import com.github.pemistahl.lingua.api.Language.BASQUE
import com.github.pemistahl.lingua.api.Language.BELARUSIAN
import com.github.pemistahl.lingua.api.Language.BENGALI
import com.github.pemistahl.lingua.api.Language.BOKMAL
import com.github.pemistahl.lingua.api.Language.BULGARIAN
import com.github.pemistahl.lingua.api.Language.CATALAN
import com.github.pemistahl.lingua.api.Language.CHINESE
import com.github.pemistahl.lingua.api.Language.CROATIAN
import com.github.pemistahl.lingua.api.Language.CZECH
import com.github.pemistahl.lingua.api.Language.DANISH
import com.github.pemistahl.lingua.api.Language.DUTCH
import com.github.pemistahl.lingua.api.Language.ENGLISH
import com.github.pemistahl.lingua.api.Language.ESTONIAN
import com.github.pemistahl.lingua.api.Language.FINNISH
import com.github.pemistahl.lingua.api.Language.FRENCH
import com.github.pemistahl.lingua.api.Language.GERMAN
import com.github.pemistahl.lingua.api.Language.GREEK
import com.github.pemistahl.lingua.api.Language.GUJARATI
import com.github.pemistahl.lingua.api.Language.HEBREW
import com.github.pemistahl.lingua.api.Language.HINDI
import com.github.pemistahl.lingua.api.Language.HUNGARIAN
import com.github.pemistahl.lingua.api.Language.ICELANDIC
import com.github.pemistahl.lingua.api.Language.INDONESIAN
import com.github.pemistahl.lingua.api.Language.IRISH
import com.github.pemistahl.lingua.api.Language.ITALIAN
import com.github.pemistahl.lingua.api.Language.JAPANESE
import com.github.pemistahl.lingua.api.Language.KOREAN
import com.github.pemistahl.lingua.api.Language.LATIN
import com.github.pemistahl.lingua.api.Language.LATVIAN
import com.github.pemistahl.lingua.api.Language.LITHUANIAN
import com.github.pemistahl.lingua.api.Language.MALAY
import com.github.pemistahl.lingua.api.Language.NORWEGIAN
import com.github.pemistahl.lingua.api.Language.NYNORSK
import com.github.pemistahl.lingua.api.Language.PERSIAN
import com.github.pemistahl.lingua.api.Language.POLISH
import com.github.pemistahl.lingua.api.Language.PORTUGUESE
import com.github.pemistahl.lingua.api.Language.PUNJABI
import com.github.pemistahl.lingua.api.Language.ROMANIAN
import com.github.pemistahl.lingua.api.Language.RUSSIAN
import com.github.pemistahl.lingua.api.Language.SLOVAK
import com.github.pemistahl.lingua.api.Language.SLOVENE
import com.github.pemistahl.lingua.api.Language.SOMALI
import com.github.pemistahl.lingua.api.Language.SPANISH
import com.github.pemistahl.lingua.api.Language.SWEDISH
import com.github.pemistahl.lingua.api.Language.TAGALOG
import com.github.pemistahl.lingua.api.Language.TAMIL
import com.github.pemistahl.lingua.api.Language.TELUGU
import com.github.pemistahl.lingua.api.Language.THAI
import com.github.pemistahl.lingua.api.Language.TURKISH
import com.github.pemistahl.lingua.api.Language.UNKNOWN
import com.github.pemistahl.lingua.api.Language.URDU
import com.github.pemistahl.lingua.api.Language.VIETNAMESE
import com.github.pemistahl.lingua.api.Language.WELSH
import com.github.pemistahl.lingua.internal.Alphabet
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class LanguageTest {

    @Test
    fun `assert that all supported languages are available`() {
        assertThat(Language.all()).containsExactly(
            AFRIKAANS, ALBANIAN, ARABIC, BASQUE, BELARUSIAN, BENGALI, BULGARIAN,
            CATALAN, CHINESE, CROATIAN, CZECH, DANISH, DUTCH, ENGLISH, ESTONIAN,
            FINNISH, FRENCH, GERMAN, GREEK, GUJARATI, HEBREW, HINDI, HUNGARIAN, ICELANDIC, INDONESIAN,
            IRISH, ITALIAN, JAPANESE, KOREAN, LATIN, LATVIAN, LITHUANIAN, MALAY, NORWEGIAN,
            PERSIAN, POLISH, PORTUGUESE, PUNJABI, ROMANIAN, RUSSIAN, SLOVAK, SLOVENE,
            SOMALI, SPANISH, SWEDISH, TAGALOG, TAMIL, TELUGU, THAI, TURKISH, URDU, VIETNAMESE, WELSH
        )
    }

    @Test
    fun `assert that all supported spoken languages are available`() {
        assertThat(Language.allSpokenOnes()).containsExactly(
            AFRIKAANS, ALBANIAN, ARABIC, BASQUE, BELARUSIAN, BENGALI, BULGARIAN,
            CATALAN, CHINESE, CROATIAN, CZECH, DANISH, DUTCH, ENGLISH, ESTONIAN,
            FINNISH, FRENCH, GERMAN, GREEK, GUJARATI, HEBREW, HINDI, HUNGARIAN, ICELANDIC, INDONESIAN,
            IRISH, ITALIAN, JAPANESE, KOREAN, LATVIAN, LITHUANIAN, MALAY, NORWEGIAN,
            PERSIAN, POLISH, PORTUGUESE, PUNJABI, ROMANIAN, RUSSIAN, SLOVAK, SLOVENE,
            SOMALI, SPANISH, SWEDISH, TAGALOG, TAMIL, TELUGU, THAI, TURKISH, URDU, VIETNAMESE, WELSH
        )
    }

    @Test
    fun `assert that certain languages support Latin alphabet`() {
        assertThat(Language.values().filter { it.alphabets.contains(Alphabet.LATIN) })
            .containsExactly(
                AFRIKAANS, ALBANIAN, BASQUE, BOKMAL, CATALAN, CROATIAN, CZECH,
                DANISH, DUTCH, ENGLISH, ESTONIAN, FINNISH, FRENCH, GERMAN,
                HUNGARIAN, ICELANDIC, INDONESIAN, IRISH, ITALIAN, LATIN, LATVIAN,
                LITHUANIAN, MALAY, NORWEGIAN, NYNORSK, POLISH, PORTUGUESE,
                ROMANIAN, SLOVAK, SLOVENE, SOMALI, SPANISH, SWEDISH, TAGALOG,
                TURKISH, VIETNAMESE, WELSH
            )
    }

    @ParameterizedTest
    @MethodSource("filteredLanguagesProvider")
    internal fun `assert that languages support correct alphabets`(
        alphabet: Alphabet,
        expectedLanguages: List<Language>
    ) {
        assertThat(
            Language.values().filter { it.alphabets.contains(alphabet) }
        ).`as`(
            "alphabet '$alphabet'"
        ).containsExactlyElementsOf(
            expectedLanguages
        )
    }

    @ParameterizedTest
    @CsvSource(
        "af, AFRIKAANS",
        "sq, ALBANIAN",
        "ar, ARABIC",
        "eu, BASQUE",
        "be, BELARUSIAN",
        "bn, BENGALI",
        "nb, BOKMAL",
        "bg, BULGARIAN",
        "ca, CATALAN",
        "zh, CHINESE",
        "hr, CROATIAN",
        "cs, CZECH",
        "da, DANISH",
        "nl, DUTCH",
        "en, ENGLISH",
        "et, ESTONIAN",
        "fi, FINNISH",
        "fr, FRENCH",
        "de, GERMAN",
        "el, GREEK",
        "gu, GUJARATI",
        "he, HEBREW",
        "hi, HINDI",
        "hu, HUNGARIAN",
        "is, ICELANDIC",
        "id, INDONESIAN",
        "ga, IRISH",
        "it, ITALIAN",
        "ja, JAPANESE",
        "la, LATIN",
        "lv, LATVIAN",
        "lt, LITHUANIAN",
        "ms, MALAY",
        "no, NORWEGIAN",
        "nn, NYNORSK",
        "fa, PERSIAN",
        "pl, POLISH",
        "pt, PORTUGUESE",
        "pa, PUNJABI",
        "ro, ROMANIAN",
        "ru, RUSSIAN",
        "sk, SLOVAK",
        "sl, SLOVENE",
        "so, SOMALI",
        "es, SPANISH",
        "sv, SWEDISH",
        "tl, TAGALOG",
        "ta, TAMIL",
        "te, TELUGU",
        "th, THAI",
        "tr, TURKISH",
        "ur, URDU",
        "vi, VIETNAMESE",
        "cy, WELSH"
    )
    fun `assert that correct language is returned for iso code`(isoCode: String, language: Language) {
        assertThat(Language.getByIsoCode(isoCode)).isEqualTo(language)
    }

    @Test
    fun `assert that exception is thrown for unknown iso code`() {
        assertThatIllegalArgumentException().isThrownBy {
            Language.getByIsoCode("dfjkglsdfg")
        }.withMessage("language with iso code 'dfjkglsdfg' can not be found")
    }

    private fun filteredLanguagesProvider() = listOf(
        arguments(Alphabet.ARABIC, listOf(ARABIC, PERSIAN, URDU)),
        arguments(Alphabet.BENGALI, listOf(BENGALI)),
        arguments(Alphabet.DEVANAGARI, listOf(HINDI)),
        arguments(Alphabet.GREEK, listOf(GREEK)),
        arguments(Alphabet.GUJARATI, listOf(GUJARATI)),
        arguments(Alphabet.GURMUKHI, listOf(PUNJABI)),
        arguments(Alphabet.HAN, listOf(CHINESE, JAPANESE)),
        arguments(Alphabet.HANGUL, listOf(KOREAN)),
        arguments(Alphabet.HEBREW, listOf(HEBREW)),
        arguments(Alphabet.HIRAGANA, listOf(JAPANESE)),
        arguments(Alphabet.KATAKANA, listOf(JAPANESE)),
        arguments(Alphabet.LATIN, listOf(AFRIKAANS, ALBANIAN, BASQUE, BOKMAL, CATALAN, CROATIAN, CZECH, DANISH, DUTCH, ENGLISH, ESTONIAN, FINNISH, FRENCH, GERMAN, HUNGARIAN, ICELANDIC, INDONESIAN, IRISH, ITALIAN, LATIN, LATVIAN, LITHUANIAN, MALAY, NORWEGIAN, NYNORSK, POLISH, PORTUGUESE, ROMANIAN, SLOVAK, SLOVENE, SOMALI, SPANISH, SWEDISH, TAGALOG, TURKISH, VIETNAMESE, WELSH)),
        arguments(Alphabet.TAMIL, listOf(TAMIL)),
        arguments(Alphabet.TELUGU, listOf(TELUGU)),
        arguments(Alphabet.THAI, listOf(THAI)),
        arguments(Alphabet.NONE, listOf(UNKNOWN))
    )
}
