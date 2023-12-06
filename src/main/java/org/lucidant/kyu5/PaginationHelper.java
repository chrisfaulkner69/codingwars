package org.lucidant.kyu5;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PaginationHelper<I> {

//    private final List<I> collection;
    private final int itemsPerPage;
    private final int itemCount;
    private final List<List<I>> pagedCollection;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(final List<I> collection, final int itemsPerPage) {
        this.pagedCollection = createPagedCollection(collection, itemsPerPage);
        this.itemsPerPage = itemsPerPage;
        this.itemCount = collection == null ? 0 : collection.size();
    }

    private List<List<I>> createPagedCollection(final List<I> collection, final int itemsPerPage) {
        if (collection == null) {
            return Collections.emptyList();
        }
        return IntStream.range(0, collection.size())
                .filter(i -> i % itemsPerPage == 0)
                .mapToObj(i -> collection.subList(i, Math.min(i + itemsPerPage, collection.size())))
                .toList();
    }
    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (itemCount == 0) {
            return 0;
        }
        final double pages = (double) itemCount / itemsPerPage;
        return (int)Math.floor(pages) + ((pages % 1) == 0 ? 0 : 1);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0) {
            return -1;
        }
        if (pageIndex <= (wholePageCount()-1)) {
            return itemsPerPage;
        }
        else if (pageIndex <= (pageCount()-1)) {
            return itemCount%itemsPerPage;
        }
        return -1;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex+1 > itemCount || itemIndex < 0) {
            return -1;
        }
        for (int i = 1; i <= pageCount(); i++) {
            final int upperLimit = i * itemsPerPage;
            if (itemIndex+1 <= upperLimit) {
                return i-1;
            }
        }
        return -1;
    }

    private int wholePageCount() {
        return (int)Math.floor((double) itemCount / itemsPerPage);
    }
}
