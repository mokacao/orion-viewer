/*
 * Orion Viewer - pdf, djvu, xps and cbz file viewer for android devices
 *
 * Copyright (C) 2011-2013  Michael Bogdanov & Co
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package universe.constellation.orion.viewer

class SubscriptionManager {

    private val listeners = arrayListOf<DocumentViewListener>()


    fun addDocListeners(listeners: DocumentViewListener) {
        this.listeners.add(listeners)
    }

    fun sendViewChangeNotification() {
        listeners.forEach { documentListener ->
            documentListener.viewParametersChanged()
        }
    }

    fun sendPageChangedNotification(newPage: Int, pageCount: Int) {
        listeners.forEach { documentListener ->
            documentListener.pageChanged(newPage, pageCount)
        }
    }

    fun sendDocOpenedNotification(controller: Controller) {
        listeners.forEach { documentListener ->
            documentListener.documentOpened(controller)
        }
    }

    fun unSubscribe(listener: DocumentViewListener) {
        listeners.remove(listener)
    }
}
