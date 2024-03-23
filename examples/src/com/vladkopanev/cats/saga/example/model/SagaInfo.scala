/* Copyright 2019 Kopaniev Vladyslav
 *
 * Copyright 2024 Jack C. Viers
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
 */

package com.vladkopanev.cats.saga.example.model

import java.time.Instant
import java.util.UUID

import io.circe.Json

case class SagaInfo(id: Long,
                    initiator: UUID,
                    createdAt: Instant,
                    finishedAt: Option[Instant],
                    data: Json,
                    `type`: String)

case class OrderSagaData(userId: UUID, orderId: BigInt, money: BigDecimal, bonuses: Double)

object OrderSagaData {
  import io.circe.*, io.circe.generic.semiauto.*
  implicit val decoder: Decoder[OrderSagaData] = deriveDecoder[OrderSagaData]
  implicit val encoder: Encoder[OrderSagaData] = deriveEncoder[OrderSagaData]
}
