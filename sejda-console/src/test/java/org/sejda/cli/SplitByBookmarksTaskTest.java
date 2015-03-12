/*
 * Created on Jul 1, 2011
 * Copyright 2011 by Eduard Weissmann (edi.weissmann@gmail.com).
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
package org.sejda.cli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sejda.model.parameter.SplitByOutlineLevelParameters;

/**
 * Tests for the SplitByBookmarksTask command line interface
 * 
 * @author Eduard Weissmann
 * 
 */
public class SplitByBookmarksTaskTest extends AbstractTaskTest {

    public SplitByBookmarksTaskTest() {
        super(TestableTask.SPLIT_BY_BOOKMARKS);
    }

    @Test
    public void bookmarksLevel_Specified() {
        SplitByOutlineLevelParameters parameters = defaultCommandLine().with("-l", "3").invokeSejdaConsole();
        assertEquals(3, parameters.getLevelToSplitAt());
    }

    @Test
    public void mandatoryParams() {
        defaultCommandLine().without("-l").assertConsoleOutputContains("Option is mandatory: --bookmarkLevel");
    }

    @Test
    public void matchingRegExp_Specified() {
        SplitByOutlineLevelParameters parameters = defaultCommandLine().with("--matchingRegEx", "[Chapter*]")
                .invokeSejdaConsole();
        assertEquals("[Chapter*]", parameters.getMatchingTitleRegEx());
    }
}
