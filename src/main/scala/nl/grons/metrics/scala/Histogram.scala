/*
 * Copyright (c) 2013-2014 Erik van Oosten
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

package nl.grons.metrics.scala

import com.codahale.metrics.{Histogram => CHHistogram, Snapshot}

/**
 * A Scala façade class for Histogram.
 *
 * @see HistogramMetric
 */
class Histogram(private val metric: CHHistogram) {

  /**
   * Adds the recorded value to the histogram sample.
   */
  def +=(value: Long) {
    metric.update(value)
  }

  /**
   * Adds the recorded value to the histogram sample.
   */
  def +=(value: Int) {
    metric.update(value)
  }

  /**
   * The number of values recorded.
   */
  def count: Long = metric.getCount

  /**
   * The largest recorded value.
   */
  def max: Long  = snapshot.getMax

  /**
   * The smallest recorded value.
   */
  def min: Long  = snapshot.getMin

  /**
   * The arithmetic mean of all recorded values.
   */
  def mean: Double = snapshot.getMean

  /**
   * The standard deviation of all recorded values.
   */
  def stdDev: Double = snapshot.getStdDev

  /**
   * A snapshot of the values in the histogram's sample.
   */
  def snapshot: Snapshot = metric.getSnapshot
}

