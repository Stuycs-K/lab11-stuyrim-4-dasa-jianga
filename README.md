[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Healer Subclass
### Stats
- **HP**: 35
- **Life Force** (Special Resource): 40 max
### Perk
- **Self-Sustain** - Recovers 1 HP and 2 Life Force every turn
### Attack
- **Smack** - Deals 2 damage and restores 5 Life Force.
### Special
- **Group Healing** - Heals all alive allies for 12 HP. Costs 20 Life Force. Healing past max HP is kept as overflow.
### Support
- **Restoration** - Heals an alive ally for 4 HP and restores 3 Life Force.


## Mage Subclass
### Stats
- **HP**: 18
- **Mana** (Special Resource): 50 max
### Perk
- **Vampire** - Defeating an enemy restores HP to max.
### Attack
- **Wand of Fire** (Normal Attack) - Deals 4 damage. Restores 7 mana.
### Special
- **Earthquake** (Special Attack) - Deals 10 damage to all enemies. Costs 20 Mana and restores 3 HP.
### Support
- **Double Damage** - User selects a character to give double damage to a randomly selected opponent. Costs 30 Mana and 3 HP

## Boss Class
### Stats
- **HP**: 100
- **Stacks** (Special resource) : 70 max
### Perk
- **Blood-Thirsty**- If an attack by the boss reduces a character to under 25% health , Stacks set to max.
### Attack
- **Devastating Blow** (Normal Attack) - Deals 7 damage. Restores 10 Stacks.
### Special
- **Carnage**(Special Attack) - Deals 10 damage. If an enemy is defeated, reset all stats to max. Costs 35 Stacks.
### Support
- **Minion**- Calls up a minion to aid in its damage.

## Minion Subclass
### Stats
- **HP**:3
- **Extra**(Special resource): 3 max
### Perk
- **No Perk**: The minion is only meant to be called up a few times by the Boss.
### Attack
- **Assault**(Normal Attack)- Deals 2 damage. Adds one Extra.
### Special
- **Mini-Devastation**(Special Attack): Attacks an opponent with as many Extra as the minion has. Minion dies afterwards.
### Support
- **Greater Cause**- Kills itself to give 3HP to the Boss and 5 Stacks.
