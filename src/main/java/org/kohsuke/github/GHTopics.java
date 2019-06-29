// Copyright 2019 Sebastian Kuerten
//
// This file is part of github-api-utils.
//
// github-api-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// github-api-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with github-api-utils. If not, see <http://www.gnu.org/licenses/>.

package org.kohsuke.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kohsuke.github.GitHub;

/**
 * Topic
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * @see <a href=
 *      "https://developer.github.com/v3/repos#list-all-topics-for-a-repository">documentation</a>
 */
public class GHTopics
{
	/* package almost final */ GitHub root;

	private List<String> names = new ArrayList<>();

	public List<String> getTopics()
	{
		return Collections.unmodifiableList(names);
	}

	/* package */ GHTopics wrapUp(GitHub root)
	{
		this.root = root;
		wrapUp();
		return this;
	}

	private void wrapUp()
	{
		// nothing
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GHTopics ghTopics = (GHTopics) o;
		return names.equals(ghTopics.names);

	}

	@Override
	public int hashCode()
	{
		return names.hashCode();
	}

	public void addTopic(String topic)
	{
		if (!names.contains(topic)) {
			names.add(topic);
		}
	}

	public void removeTopic(String topic)
	{
		names.remove(topic);
	}

	public void clearTopics()
	{
		names.clear();
	}

}