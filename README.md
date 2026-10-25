# Spite 
because bta pisses me off

## Server side  
### Optimizations:  
- Lobotomize mobs once they leave (default) entity view distance (~64 blocks)
- Previously nether-exclusive optimizations are now applied to every dimension
### Fixes:
- Disable "Player moved too fast/wrongly!" (Taken from [I'm Fast](https://modrinth.com/mod/im-fast))  
--- 
Spite is a fork of [Spike](https://github.com/RoughCipher/Spike), and thus inherits all of its features.
<details>
  <summary>Features inherited from Spike:</summary>

## Both
### Fixes:
- Languages from mods (any except en_US) are loaded again.
- Leaf decay radius 4 → 7 + BFS search, fancytree foliage still finds logs after player chunk updates.
- WeatherChunkLoad (StackOverflowError).
- Chat command: moving the cursor no longer crashes or kicks the player.
### Optimizations:
- PacketBlockRegionUpdate: fast compression + pooled Deflater/Inflater.
## Server side
### Features:
- Spectator players are not sent to non-spectators. Works even for clients without Spike.
### Fixes:
- Fix unban username.
- ban ip / unban ip accept IPv6.
- ip ban check on login correctly handles IPv6 (vanilla cut at first ':').
- server.properties/default-gamemode.
- New players can use creative inventory when default-gamemode is creative.
- Recursion protection disabled (clipped structures).
- world-type: Nether now receives the matching world type (e.g. skyblock/beta_173).
- Player spawn.
### Optimizations:
- Spawn chunks configurable (default false).  
  When enabled: only overworld spawn area is prepared and kept loaded.
- Async terrain generation. Decorate stays on main thread.
- Chunk send order better after teleports/login.
## Client side
### Features:
- Lower minimum OpenGL 4.1 → 3.3 (old GPU support).
- Spectator players are invisible to non-spectators; other spectators see them translucent.
- Support launch argument `--accessToken` (alias for `--session`).
### Fixes:
- Language pack GUI: when several packs share the same id, only the selected one is highlighted and loaded (selection stored in options.txt as languagePackKey).
- Fix subtitles for rubyglass-blocks.
- Fix read server icons.
- Proper text cursor behavior (e.g., IPv6 input).
- LAN server list shows a clean host:port (IPv4-mapped / zone id).
- CameraFrustum.cubeInFrustum now respects FRUSTUM_CULLING option.
- ### Optimizations:
- Cap nearchunk rebuilds perframe.
- PacketChunkBlocksUpdate: raw setBlock + single markBlocksDirty.

  --- 

</details>
