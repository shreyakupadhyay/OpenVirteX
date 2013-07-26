/**
 *  Copyright (c) 2013 Open Networking Laboratory
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 * 
 */

package net.onrc.openvirtex.core;

import net.onrc.openvirtex.core.cmd.CmdLineSettings;
import net.onrc.openvirtex.exceptions.OpenVirteXException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OpenVirteX {

    static Logger log = LogManager.getLogger(OpenVirteX.class.getName());
	/**
	 * @param args
	 */
    public static void main(String[] args) throws OpenVirteXException {
	CmdLineSettings settings = new CmdLineSettings();
	CmdLineParser parser = new CmdLineParser(settings);
	try {
	    parser.parseArgument(args);
	} catch (CmdLineException e) {
	    parser.printUsage(System.out);
	    System.exit(1);
	}
	
	OpenVirteXController ctrl = new OpenVirteXController(settings.getConfigFile(), settings.getOFHost(), settings.getOFPort());
	log.info("Starting OpenVirtex...");
	ctrl.run();
    }

}