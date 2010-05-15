// Copyright 2010 owners of the AI Challenge project
//
// Licensed under the Apache License, Version 2.0 (the "License"); you may not
// use this file except in compliance with the License. You may obtain a copy
// of the License at http://www.apache.org/licenses/LICENSE-2.0 . Unless
// required by applicable law or agreed to in writing, software distributed
// under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
// CONDITIONS OF ANY KIND, either express or implied. See the License for the
// specific language governing permissions and limitations under the License.
//
// Author: Jeff Cameron (jeff@jpcameron.com)
//
// This class is for testing the map rendering code. It loads one game state
// from a file and renders it.

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class RenderMap {
    public static void main(String[] args) {
	try {
	    if (args.length != 2) {
		System.err.println("USAGE: java RenderMap map.txt image.png");
	    }
	    Game game = new Game(args[0], 100, 0);
	    if (game.Init() == 0) {
		System.err.println("Error while loading map " + args[0]);
		System.exit(1);
	    }
	    BufferedImage image = game.Render(640, 480, 0.0);
	    File file = new File(args[1]);
	    ImageIO.write(image, "png", file);
	} catch (Exception e) {
	    System.err.println(e);
	}
    }
}
