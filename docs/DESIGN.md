# Alchemicraft design

## Overview

Alchemicraft is a serious magic mod for Minecraft. The aim is to enrich a modpack, not to be played for laughs. The science in the mod is what explains the magic already in the Minecraft world.

It should feel like its own creation, not a Thaumcraft or Equivalent Exchange clone. Borrowing a good idea is fine. Copying their feel is not.

The player starts with no magical knowledge and has to find and make their first tool. Progression should go well past a single stone. Gear is built around a signature material, Vessium, that can only be made through this mod's alchemy.

Helper creatures belong to Simple Golems, not here. No new worldgen unless it is truly needed. The mod is standalone; tie-ins with other Workshopcraft mods are optional.

It is built from one codebase for 1.20.1 (Forge, Fabric), 1.21.1 (NeoForge, Fabric) and 26.1.2, 26.2, 26.3 (NeoForge, Fabric). Game logic stays in common code, element values live in data files, and version-specific code stays thin.

## Elements

Six base elements in three opposite pairs:

- Life and Death
- Fire and Ice
- Chaos and Stable

Items, blocks and mobs break down into several base elements, not one. The lens shows that mix. An ender pearl, for example, gives Ice and Chaos, which is why it relates to Warp.

Combining two base elements gives a combination element. There are 15 combinations, so 21 elements in total. The combination names below are drafts.

Opposites:

- Life + Death = Undeath (necromancy, runs zombies)
- Fire + Ice = Air (levitation, flight)
- Chaos + Stable = Transmute (core alchemy)

Other pairs:

- Life + Fire = Lightning
- Life + Ice = Water
- Life + Chaos = Mutation
- Life + Stable = Growth
- Death + Fire = Ash (incinerate)
- Death + Ice = Preserve
- Death + Chaos = Plague
- Death + Stable = Bone
- Fire + Chaos = Blast
- Fire + Stable = Forge (used to make Vessium)
- Ice + Chaos = Warp (teleport)
- Ice + Stable = Crystal (shields)

Draft sources: Life from food, plants and living mobs; Death from rotten flesh, bone and wither rose; Fire from blaze powder and magma; Ice from snow and ice; Chaos from gunpowder, ender pearls and chorus; Stable from stone, iron and obsidian.

Elements are liquids that can be turned into crystals. They can be carried in flasks. Other mods' tanks can be used if those mods are loaded.

Open: a full breakdown table for vanilla items, blocks and mobs, and a fallback for items from other mods.

## Getting started

The player brushes suspicious sand or gravel in existing ruins (trail ruins, desert pyramids and wells, ocean ruins) and can find an old alchemist's fragment. The fragment teaches the lens recipe: amethyst and copper. No new worldgen.

The lens shows what any block, item or mob is made of, and stays the knowledge tool for the whole mod.

Knowledge comes from three routes that feed one pool: fragments, studying the world with the lens, and experiments.

## Extraction

Extraction is tiered and always lossy, so there are no remake loops.

- Mortar and pestle first: low yield, strongest element only.
- Copper still next: a full split, and the only way to get combination elements out of items.
- Bottling from world sources as a bonus the lens can hint at.

The catalyst is alchemist's salt, made by grinding amethyst shards in the mortar. Each extraction consumes salt. Amethyst is renewable from budding amethyst, which has to be farmed in place at geodes. The still uses the same salt for now.

Open: whether the still later needs a stronger catalyst.

## Combining

Combinations are made by distillation with modular glassware. Heated flask stands hold base liquids, vapours travel through glass tubes to a condenser, then drip into a collecting flask as the combined element.

Three heat tiers:

- Basic heat (campfire or furnace) for neighbouring pairs, such as Lightning, Growth and Forge.
- Controlled heat (blaze burner or lava heater) for tougher pairs, such as Blast, Ash and Plague.
- Heat plus a cooling jacket for opposite pairs (Air, Undeath, Transmute): one flask hot, one cold. This is endgame.

Open: the exact heat tier for each of the 15 combinations.

## Refining

Only refined elements make reliable flasks. Throwing a raw, unrefined element is unpredictable: a random or weak mix of that element's effects. Raw Life might grow, heal, or hurt undead at random. Refining picks one focused effect.

Life heals living things and hurts undead. Death does the reverse, and can mend dark golems.

Refining uses no outside reagents. The player uses the lens on vanilla items (for example bone meal) to learn which element to titrate into a base element for an effect (for example growth). Titration is mixing elements at different ratios. The ratio affects quality and strength. Secret mixes (hidden ratios or extra elements) give further effects, found only by experimenting.

The titration setup is a burette on a stand. The player clicks to add one drop at a time, the flask colour shifts, and the lens shows the exact ratio and the effect it is heading towards. The liquid shimmers at a sweet spot, which is how secret mixes are spotted.

Open: each item's element mix, including bone meal, and how secret mixes are hinted before the player finds them.

## Crystals

Crystals take several steps. For a one-off crystal, a crystallising kiln concentrates the liquid with heat and an alchemist's salt seed, then a cooling basin cools it into a crystal.

For long-term farming, the player seeds budding amethyst geodes with element liquid, and element crystal clusters grow over time.

Crystals can be melted back into liquid with a small loss, so they work as compact storage without opening a loop.

Intended uses, not final: wand cores that never run dry, ritual pedestal focuses, and a compact way to store and trade elements.

Open: crystal size and amounts, and geode growth speed.

## Progression

Utility first, defence second, offence later.

Defence starts with the first Vessium armour layer, likely Stable for toughness. Offence comes later, after controlled-heat elements.

## Flasks

Thrown utility items are flasks that share a spreading wave from the impact point.

Accepted first items:

- Growth flask (Life): green particles. Dirt becomes grass, crops grow a stage, saplings get a growth tick.
- Frost flask (Ice): pale blue wave. Water becomes frosted or turns to ice, lava becomes obsidian, fire is put out, and snow layers form on top surfaces.
- Death flask: purple wave. Wilts grass to dirt, and clears weeds and flowers.
- Ember lantern (Fire): a placed, fuel-free light, not a thrown flask.

A healing or regen flask, likely Life-based, has been suggested but not decided.

Open: growth flask radius, spread speed, and whether flowers, moss and mycelium count. Open: whether the healing flask is heal, regen, or both, and whether it affects mobs.

## Vessium

Vessium is the signature material. The name is a vessel for elements, which matches the layering. No other Minecraft mod uses the name.

It is made by ritual, and this is the player's first ritual (small tier, so it only fizzles if it fails). Gold ingots go on the central altar, Forge liquid (Fire + Stable) is poured into the pedestals, and amethyst is the catalyst. The player has to make their first combination before their first ritual.

One base Vessium is used for all gear. Other elements are imbued on top as layers.

Open: ritual batch size.

## Armour and weapon layers

Plain Vessium armour comes first. Element layers are then added one at a time at a coating station. Each layer shows as a coloured sheen.

There is no layer cap. Cost rises with each layer. Ultimate armour should be painful to make, possibly literally: past about three layers, coating also needs a blood price (temporary max health loss while it sets, or a Life sacrifice). The blood price itself is not final.

Same-element layers stack with diminishing returns.

Base layer ideas, not final:

- Stable: toughness and knockback resistance. The first layer taught.
- Fire: fire resist, and scorches attackers.
- Ice: slows attackers, and lets you walk on powder snow.
- Life: slow regen.
- Death: undead ignore you unless provoked.
- Chaos: a small dodge chance.

Combination layers are stronger, for example Forge plating.

Vanilla weapons, including looted ones, take the same layers at the same coating station, with the same rising cost. Vessium weapons hold more layers before the cost climbs. Example ideas: a bow whose drawn arrow bursts into flames, and a sword that heals you with each hit (Life).

Open: how strong the blood price is.

## Wands

There are multiple wands, one per element or role, and they are tiered like the armour. Shots consume element liquid.

First-pass tiers (more tiers are likely later):

- Wooden wand with a copper tip: base elements, small capacity.
- Vessium wand: more capacity, basic-heat combination spells.
- Crystal-cored wand: never runs dry, slow recharge, opposite-pair spells.

Spell ideas, not final: Fire flame jet, Ice frost bolt, Life heal ally or burn undead, Death wither drain, Chaos random knockback or blink, Stable pin or stop teleport. Later combos: Lightning chain, Blast (no block damage), Warp short teleport.

## Rituals

The lab makes elements. The altar spends them in bulk for effects too large for a flask or wand.

A central altar sits with pedestals around it in a pattern. The player pours element liquids or sets crystals in. Coloured streams flow from the pedestals to the centre, the ground glows in the element's colour, and it ends in a flash.

Rituals cover world effects, summoning, and top-tier gear.

Learning: fragments show half a pedestal diagram, and the lens fills in the rest.

Failure: small rituals fizzle and the elements are lost. Big rituals backlash with the element's own effect (a failed Fire ritual sets fires, a failed Death ritual spawns a hostile zombie). The Vessium ritual is a small one.

Example rituals, not final:

- Weather: Ice or Water for rain, Fire to clear the sky.
- Raising a dark golem: a zombie on the altar, Death and Undeath poured in, a Life sacrifice to power it.
- Binding a waystone: Warp, sets a teleport point a wand can return to.
- Top-tier Vessium forging, for the highest armour and wand layers.

Open: altar tiers and materials, and the pedestal patterns.

## Necromancy

Dark golems are ritual-raised undead. They are grim and dangerous, built for fighting and guarding, and they run on life energy from sacrifice. Costly upkeep is part of the point.

They stay out of Simple Golems' lane. That mod covers cute clay chore workers, item job cards, food upkeep, and farm or logistics jobs. A combat undead minion is fine. A friendly chore worker is not. Claytech is not briefed yet, and will need a check when it is.

Dark golems can herd passive mobs into a ritual circle to be sacrificed, feeding Death energy (and possibly Life) into the altar. That energy can be stored in tanks and used for golem upkeep and large rituals. The block used for this is a sacrifice block (name TBD).

Balance ideas, not final: a fixed amount of energy per mob; villagers worth more, but they turn nearby villages hostile.

Open: golem types, the sacrifice block's real name, and the upkeep numbers.

## Mob schools

These schools use mobs as the source, because the lens already shows what they are made of. Details are not final.

- Flight from bats. Early: slow-fall boots. Later: true flight, as gliding wings or a hover layer on Vessium boots.
- Teleportation from endermen, the main source of Warp. Blink wands, waystone rituals, and maybe an ender pocket.
- Channelling from the Warden. A channelled beam that goes through walls and armour, as the top-tier attack. The essence is rare and only comes from a Warden kill.
- Summoning from witches. Summoning circles that call temporary spirits or familiars.

Witches also drop knowledge fragments, which gives a reason to build a witch farm early. Drops are rare, only for fragments the player has not learned yet, and they stop once all are known. The witch has to be killed by a player. A fully automated farm does not yield fragments.

## Open questions

Things still undecided:

- Full element breakdown table for vanilla items, blocks and mobs, plus a fallback for other mods' items.
- Final names for the 15 combinations, and which heat tier each one sits in.
- Whether the copper still later needs a stronger catalyst.
- Growth flask radius, spread speed, and which blocks it affects.
- Healing flask: heal, regen, or both, and whether it affects mobs.
- How secret mixes are hinted before the player finds them.
- Crystal size and amounts, and geode growth speed.
- Vessium ritual batch size.
- How strong the blood price is.
- Altar tiers, materials, and pedestal patterns.
- Dark golem types, sacrifice block name, and upkeep numbers.
- Knowledge flow: where else fragments drop, whether there is a journal or guidebook, and the unlock order.
- How Alchemicraft should sit alongside Simple Machines power armour.
- How the mod talks to other mods' tanks and to recipe viewers such as JEI.
- Details of the mob schools (flight items, waystones, Warden beam, witch familiars).
- More wand tiers, later.
