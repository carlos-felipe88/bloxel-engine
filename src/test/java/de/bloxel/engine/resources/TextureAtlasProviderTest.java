/*******************************************************************************
 * Copyright (c) 2012 Andreas Höhmann
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 *******************************************************************************/
package de.bloxel.engine.resources;

import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.mockito.Mock;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.jme3.asset.AssetManager;
import com.jme3.math.Vector2f;

public class TextureAtlasProviderTest extends PowerMockTestCase {

  @Mock
  private AssetManager assetManager;

  @Test
  public void testLoading() throws Exception {
    final TextureAtlasProvider textureAtlasProvider = new TextureAtlasProvider(assetManager);
    assertEquals(textureAtlasProvider.getTextureCoordinates("grass"), ImmutableList.of(Vector2f.ZERO, new Vector2f(
        0.0625f, 0), new Vector2f(0, 0.0625f), new Vector2f(0.0625f, 0.0625f)));
    verify(assetManager).loadTexture("texture/minecraft.png");
    assertNull(textureAtlasProvider.getTextureCoordinates("foobar"));
  }
}
