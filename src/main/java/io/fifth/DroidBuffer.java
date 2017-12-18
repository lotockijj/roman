package io.fifth;

import java.io.FilterInputStream;
import java.io.InputStream;

/**Try to create DroidBuffer class, which can be used for read and write data from/to channel (Java NIO)
 */

public class DroidBuffer extends FilterInputStream{

	protected DroidBuffer(InputStream in) {
		super(in);
	}

}
