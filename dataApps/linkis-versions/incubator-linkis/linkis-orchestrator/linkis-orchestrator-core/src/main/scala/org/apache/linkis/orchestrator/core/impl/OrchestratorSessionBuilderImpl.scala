/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package org.apache.linkis.orchestrator.core.impl

import org.apache.linkis.orchestrator.OrchestratorSession
import org.apache.linkis.orchestrator.core.{AbstractOrchestratorSessionBuilder, SessionState}
import org.apache.linkis.orchestrator.extensions.Extensions
import org.apache.linkis.orchestrator.extensions.catalyst.{CheckRuler, Transform}
import org.apache.linkis.orchestrator.extensions.operation.Operation

/**
  *
  */
class OrchestratorSessionBuilderImpl extends AbstractOrchestratorSessionBuilder {

  override def createOrchestratorSession(createSessionState: OrchestratorSession => SessionState): OrchestratorSession = {
    val orchestratorSession = new OrchestratorSessionImpl(orchestrator, createSessionState)
    orchestratorSession
  }

  override protected def createSessionState(orchestratorSession: OrchestratorSession,
                                            transforms: Array[Transform[_, _, _]],
                                            checkRulers: Array[CheckRuler[_, _]],
                                            operations: Array[Operation[_]],
                                            extractExtensions: Array[Extensions[_]]): SessionState =
    new SessionStateImpl(orchestratorSession, transforms, checkRulers, operations, extractExtensions)

}
