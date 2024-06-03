package gaia.attachment.friended;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

import java.util.UUID;

public class Friended implements IFriended, INBTSerializable<CompoundTag> {
	private boolean friended = false;
	private UUID friendedBy = null;
	private boolean changed = false;

	@Override
	public boolean isFriendly() {
		return friended;
	}

	@Override
	public UUID getFriendedBy() {
		return friendedBy;
	}

	@Override
	public void setFriendedBy(UUID friendedBy) {
		this.friendedBy = friendedBy;
	}

	@Override
	public boolean isChanged() {
		return changed;
	}

	@Override
	public void setFriendly(boolean value) {
		this.friended = value;
		this.setChanged(true);
	}

	@Override
	public void setChanged(boolean value) {
		this.changed = value;
	}

	@Override
	public CompoundTag serializeNBT(HolderLookup.Provider provider) {
		CompoundTag tag = new CompoundTag();
		tag.putBoolean("friended", this.isFriendly());
		if (this.getFriendedBy() != null)
			tag.putUUID("friendedBy", this.getFriendedBy());
		return tag;
	}

	@Override
	public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
		this.setFriendly(tag.getBoolean("friended"));
		if (tag.contains("friendedBy"))
			this.setFriendedBy(tag.getUUID("friendedBy"));
	}
}
