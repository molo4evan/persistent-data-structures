package ru.nsu.mmp.pds

/**
 * Marks PDS as partially persistent.
 * This means that you may query any previous version of a PDS,
 * but may only update the latest version.
 */
interface PartiallyPersistent

/**
 * Marks PDS as fully persistent.
 * This means that you may perform either queries and updates on any PDS version.
 */
interface FullyPersistent