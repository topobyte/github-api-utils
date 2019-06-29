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

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class Topics
{

	public static GHTopics get(GHRepository repository) throws IOException
	{
		GitHub github = repository.root;
		Requester requester = new Requester(github).method("GET");
		// Set a special header so that the API won't return an error message
		// instead of actual content
		requester.setHeader("Accept",
				"application/vnd.github.mercy-preview+json");
		GHTopics topics = requester.to(
				String.format("/repos/%s/topics", repository.getFullName()),
				GHTopics.class);
		return topics;
	}

	public static void update(GHRepository repository, GHTopics topics)
			throws IOException
	{
		GitHub github = repository.root;
		Requester requester = new Requester(github).method("PUT");
		// Set a special header so that the API won't return an error message
		// instead of actual content
		requester.setHeader("Accept",
				"application/vnd.github.mercy-preview+json");
		requester.with("names", topics.getTopics());
		requester.to(
				String.format("/repos/%s/topics", repository.getFullName()),
				GHTopics.class);
	}

}
