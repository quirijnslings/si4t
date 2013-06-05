/**
 * Copyright 2011-2013 Radagio & SDL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tridion.storage.si4t;

import org.slf4j.Logger;

import com.tridion.storage.services.LocalThreadTransaction;

/**
 * TridionBaseItemProcessor.
 * 
 * @author R.S. Kempees
 * @version 1.20
 * @since 1.00
 */
public class TridionBaseItemProcessor
{
	protected static void registerItemAddition(SearchIndexData data, Logger log)
	{
		SearchIndexProcessor.registerAction(LocalThreadTransaction.getTransactionId(), data, log);
	}

	public static void registerItemRemoval(String indexId, IndexType type, Logger log, String publicationId, String storageId)
	{
		BaseIndexData removalData = new BaseIndexData(FactoryAction.REMOVE, type, publicationId, storageId);
		removalData.setUniqueIndexId(indexId);
		SearchIndexProcessor.registerAction(LocalThreadTransaction.getTransactionId(), removalData, log);
	}
}
