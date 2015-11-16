package com.birbalv2.helper;

import junit.framework.Assert;

import org.junit.Test;

import com.birbalv2.constant.Intent;
import com.birbalv2.model.WitOutput;

public class WitHelperTest {
	WitHelper witHelper = new WitHelper();

	@Test
	public void testWit() throws Exception {
		WitOutput witOutput = witHelper.getIntent("Who are you");
		Assert.assertEquals(Intent.BOTS_NAME, witOutput.getIntent());
		System.out.println(witOutput.getConfidence());
	}
}
