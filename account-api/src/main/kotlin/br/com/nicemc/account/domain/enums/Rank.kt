package br.com.nicemc.account.domain.enums

import br.com.nicemc.account.domain.exceptions.RankNotFoundException

enum class Rank(
    val minimumXp: Int
) {

    BRONZE(0),
    SILVER(100),
    GOLD(1000);

    companion object {

        fun findByXp(xp: Int): Rank {
            if (xp < 0) {
                throw RankNotFoundException("No rank found for the range of XP $xp")
            }
            var rank = BRONZE
            for (r in values()) {
                if (r.minimumXp < xp) {
                    rank = r
                }
            }
            return rank
        }

    }

}