/*
 *     Copyright (C) 2020 Florian Stober
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.codecrafter47.data.velocity.luckperms;

import com.velocitypowered.api.proxy.Player;
import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.User;

import java.util.function.Function;

public class LuckPermsPrimaryGroupProvider implements Function<Player, String> {

    @Override
    public String apply(Player player) {
        LuckPermsApi lp = LuckPerms.getApiSafe().orElse(null);
        if (lp == null) {
            return null;
        }

        User user = lp.getUser(player.getUniqueId());
        if (user == null) {
            return null;
        }

        return user.getPrimaryGroup();
    }
}
