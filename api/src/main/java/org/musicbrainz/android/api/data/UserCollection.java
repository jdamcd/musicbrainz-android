package org.musicbrainz.android.api.data;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class UserCollection extends UserCollectionInfo {
	
	private SortedSet<ReleaseInfo> releases = new TreeSet<ReleaseInfo>();

	public SortedSet<ReleaseInfo> getReleases() {
		return releases;
	}

	public void setReleases(SortedSet<ReleaseInfo> releases) {
		this.releases = releases;
	}
	
	public void addRelease(ReleaseInfo release) {
	    this.releases.add(release);
	}

  public void addReleases(Collection<ReleaseInfo> releases) {
      this.releases.addAll(releases);
  }
}
