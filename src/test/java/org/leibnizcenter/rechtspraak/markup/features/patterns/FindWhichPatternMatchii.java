package org.leibnizcenter.rechtspraak.markup.features.patterns;

import org.leibnizcenter.rechtspraak.features.title.TitlePatterns;

import java.io.IOException;

/**
 * Created by maarten on 17-3-16.
 */
public class FindWhichPatternMatchii {

    public static void main(String[] a) throws IOException {
        for (TitlePatterns.TitlesNormalizedMatches pattern : TitlePatterns.TitlesNormalizedMatches.set) {
            if (pattern.matches("ii")) {
                break;
            }
        }
    }
}
