/*BEGIN_COPYRIGHT_BLOCK
 *
 * Copyright (c) 2001-2010, JavaPLT group at Rice University (drjava@rice.edu)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the names of DrJava, the JavaPLT group, Rice University, nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software is Open Source Initiative approved Open Source Software.
 * Open Source Initative Approved is a trademark of the Open Source Initiative.
 * 
 * This file is part of DrJava.  Download the current version of this project
 * from http://www.drjava.org/ or http://sourceforge.net/projects/drjava/
 * 
 * END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava.model.junit;

import edu.rice.cs.drjava.model.compiler.CompilerListener;
import edu.rice.cs.util.classloader.ClassFileError;
import edu.rice.cs.drjava.model.OpenDefinitionsDocument;
import java.util.List;

/** * An interface for responding to events generated by the JUnitModel.
 *
 * @version $Id$
 */
public interface JUnitListener {
  
  /** Called when trying to test a non-TestCase class.
    * @param isTestAll whether or not it was a use of the test all button
    * @param didCompileFail whether or not a compile before this JUnit attempt failed
    */
  public void nonTestCase(boolean isTestAll, boolean didCompileFail);
  
  /** Called when JUnit encounters an illegal class file.
    * @param e the error or exception thrown by loading and resolving f.
    */
  public void classFileError(ClassFileError e);
  
  /** Called after JUnit is started by the GlobalModel. */
  public void junitStarted();
  
  /** Called when testing a specific list of classes given their source files. */
  public void junitClassesStarted();
  
  /** Called to indicate that a suite of tests has started running.
    * @param numTests The number of tests in the suite to be run.
    */
  public void junitSuiteStarted(int numTests);
  
  /** Called when a particular test is started.
    * @param name The name of the test being started.
    */
  public void junitTestStarted(String name);
  
  /** Called when a particular test has ended.
    * @param name The name of the test that has ended.
    * @param wasSuccessful Whether the test passed or not.
    * @param causedError If not successful, whether the test caused an error or simply failed.
    */
  public void junitTestEnded(String name, boolean wasSuccessful, boolean causedError);
  
  /** Called after JUnit is finished running tests. */
  public void junitEnded();
  
  /** Demands that all source files be in sync before running JUnit tests. 
   * The caller of this method must check if the documents are in sync with 
   * their class files using OpenDefinitionsDocument.checkIfClassFileInSync().
   * @param l the listener
   * @param outOfSync documents that are out of sync
   */
  public void compileBeforeJUnit(final CompilerListener l, List<OpenDefinitionsDocument> outOfSync);
}
