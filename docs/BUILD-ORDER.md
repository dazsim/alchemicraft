# Build order

A first pass at what to build, starting with the smallest playable slice. Later milestones can move once the early ones are in and playable.

## M1: Lens and first knowledge

- Archaeology loot: alchemist's fragments in existing ruins (suspicious sand and gravel in trail ruins, desert pyramids and wells, ocean ruins).
- Lens item, crafted from amethyst and copper, recipe taught by the fragment.
- Element readout tooltip when looking at a block, item or mob with the lens.
- A small element data table covering a handful of vanilla items, enough to prove the mix readout.

Built so far:

- Fragments come from brushing suspicious sand and gravel at desert wells and pyramids, trail ruins and ocean ruins, roughly 1 in 7 to 1 in 12 brushes. Fabric adds a weighted entry to the vanilla pool; NeoForge and Forge use a loot modifier at the same odds.
- Using a fragment unlocks the lens recipe in the recipe book and uses up the fragment. If the recipe is already known the fragment stays. The recipe is 4 copper ingots around an amethyst shard. Like vanilla recipes, it still crafts for a player who has not unlocked it.
- Holding the lens in either hand shows the elements of the looked-at mob, dropped item or block on the action bar. With nothing in sight it reads the item in the other hand. The server works this out, so it uses the server's data packs and needs no custom network code.
- Element values are data: `data/<namespace>/alchemicraft/elements/*.json`, with `items`, `blocks` and `entities` sections. A block with no entry uses its item's entry. The vanilla values are drafts.

## M2: Mortar, salt and liquids

- Mortar and pestle.
- Alchemist's salt, made by grinding amethyst shards in the mortar.
- Extract the strongest element from an item, at low yield, consuming salt. Lossy.
- Element liquids and flasks to hold them.

## M3: Copper still

- Copper still block.
- Full element split from an item, still lossy, still consuming salt.
- This is the first way to obtain combination elements that are already present in an item.

## M4: Basic distillation and Forge

- Modular glassware: flask stands, tubes, condenser, collecting flask.
- Basic heat (campfire or furnace) distillation.
- Combine Fire and Stable into Forge. Other neighbouring pairs can follow, but Forge is the one that unblocks the next milestone.

## M5: Altar and Vessium

- Central altar and pedestals.
- Ritual visuals: coloured streams, ground glow, flash.
- Vessium ritual: gold ingots, Forge liquid, amethyst catalyst. Small ritual, fizzles on failure.
- Vessium as an item (ingot or similar).

## Later milestones

These are not in a strict order yet, but this is a sensible sequence after Vessium exists.

### Flasks with spread effects

- Thrown flasks with the spreading wave.
- Growth flask, frost flask (including lava to obsidian), and death flask.
- Ember lantern.

### Vessium armour and the coating station

- Plain Vessium armour.
- Coating station and the first layer (likely Stable).
- Rising cost, and diminishing returns on same-element layers. Blood price can wait.

### Wands

- Wooden copper-tipped wand for base elements.
- Vessium wand for basic-heat combos.
- Crystal-cored wand once crystals exist.

### Crystals

- Crystallising kiln and cooling basin.
- Melt back to liquid with a small loss.
- Geode seeding for long-term farming.

### Titration

- Burette stand, drop-by-drop mixing, and colour shift.
- Lens ratio readout and sweet-spot shimmer.
- Reliable refined flasks. Raw elements stay unpredictable.

### Bigger rituals

- Weather, waystone, and other world-effect rituals.
- Failure: big rituals backlash.
- Top-tier gear rituals.

### Dark golems

- Ritual to raise a combat undead minion.
- Life-energy upkeep.
- Sacrifice block (name TBD), and herding sacrifices into a ritual circle.

### Mob schools

- Bat flight (slow-fall first).
- Enderman Warp (blink, waystones).
- Warden channelling beam.
- Witch summoning, and player-kill knowledge fragments.
