/**
 * 
 */
package com.osmaga.ejb;

import javax.ejb.Remote;

/**
 * @author osmaga
 *
 */
@Remote
public interface HelloRemote {

	String hello();
}
