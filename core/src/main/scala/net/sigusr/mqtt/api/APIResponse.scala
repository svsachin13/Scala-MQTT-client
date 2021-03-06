/*
 * Copyright 2014 Frédéric Cabestre
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

package net.sigusr.mqtt.api

sealed trait APIResponse

case object Connected extends APIResponse
case class ConnectionFailure(reason: ConnectionFailureReason) extends APIResponse

case object Disconnected extends APIResponse

case class Published(messageId: MessageId) extends APIResponse
case class Message(topic: String, payload: Vector[Byte]) extends APIResponse

case class Subscribed(topicResults: Vector[QualityOfService], messageId: MessageId) extends APIResponse

case class Unsubscribed(messageId: MessageId) extends APIResponse

case class Error(kind: ErrorKind) extends APIResponse