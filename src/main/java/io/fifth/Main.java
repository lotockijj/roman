package io.fifth;

import java.io.FileWriter;
import java.io.IOException;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;

/**Write a program that reads a Java source-code file 
 * (you provide the file name on the command line) and displays all the comments. 
 * Do not use regular expression.
 */

public class Main {

	    public static boolean start(RootDoc root) throws IOException {
	        for (ClassDoc c : root.classes()) {
	            print(c.qualifiedName(), c.commentText());
	            for (FieldDoc f : c.fields(false)) {
	                print(f.qualifiedName(), f.commentText());
	            }
	            for (MethodDoc m : c.methods(false)) {
	                print(m.qualifiedName(), m.commentText());
	                if (m.commentText() != null && m.commentText().length() > 0) {
	                    for (ParamTag p : m.paramTags())
	                        print(m.qualifiedName() + "@" + p.parameterName(), p.parameterComment());
	                    for (Tag t : m.tags("return")) {
	                        if (t.text() != null && t.text().length() > 0)
	                            print(m.qualifiedName() + "@return", t.text());
	                    }
	                }
	            }
	        }
	        return true;
	    }

	    private static void print(String name, String comment) throws IOException {
	        if (comment != null && comment.length() > 0) {
	            new FileWriter(name + ".txt").append(comment).close();
	        }
	    }
	    
	
}
